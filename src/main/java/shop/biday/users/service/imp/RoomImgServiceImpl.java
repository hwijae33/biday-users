package shop.biday.users.service.imp;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import shop.biday.users.model.domain.RoomImgAddDTO;
import shop.biday.users.model.entity.Room;
import shop.biday.users.model.entity.RoomImg;
import shop.biday.users.model.repository.RoomImgRepository;
import shop.biday.users.model.repository.RoomRepository;
import shop.biday.users.service.RoomImgService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class RoomImgServiceImpl implements RoomImgService {

    private final RoomRepository ROOMREPOSITORY;
    private final RoomImgRepository ROOMIMGREPOSITORY;


    public Map<String, Object> uploadFiles(Long roomId, MultipartFile[] files) throws IOException {
        Map<String, Object> resultMap = new HashMap<>();
        StringBuilder fileNames = new StringBuilder();

        Path uploadPath = Paths.get("src/main/resources/static/uploads");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        List<String> savedFiles = List.of(files).stream()
                .filter(mf -> !mf.isEmpty())
                .map(mf -> {
                    try {
                        String originalFileName = mf.getOriginalFilename();
                        String extension = "";
                        if (originalFileName != null && originalFileName.contains(".")) {
                            extension = originalFileName.substring(originalFileName.lastIndexOf('.') + 1);
                        }

                        String uuid = UUID.randomUUID().toString();
                        String safeFile = uuid + "." + extension;
                        fileNames.append(",").append(safeFile);

                        Path filePath = uploadPath.resolve(safeFile);
                        try (InputStream inputStream = mf.getInputStream()) {
                            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                        }

                        // Save file info to the database
                        RoomImgAddDTO roomImgAddDTO = new RoomImgAddDTO();
                        roomImgAddDTO.setRoomId(roomId);
                        roomImgAddDTO.setName(uuid);
                        roomImgAddDTO.setNameOriginal(originalFileName);
                        roomImgAddDTO.setSize(String.valueOf(mf.getSize()));
                        roomImgAddDTO.setExt(extension);

                        saveRoomImg(roomImgAddDTO);

                        return safeFile;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .filter(fileName -> fileName != null)
                .collect(Collectors.toList());

        String fileNamesString = savedFiles.isEmpty() ? "" : String.join(",", savedFiles);
        resultMap.put("FileNames", fileNamesString);

        return resultMap;
    }

    private void saveRoomImg(RoomImgAddDTO roomImgAddDTO) {
        Optional<Room> roomOptional = ROOMREPOSITORY.findById(roomImgAddDTO.getRoomId());

        Room room = roomOptional.orElseThrow(() -> new RuntimeException("Room not found"));

        RoomImg roomImg = RoomImg.builder()
                .room(room)
                .name(roomImgAddDTO.getName())
                .nameOriginal(roomImgAddDTO.getNameOriginal())
                .size(roomImgAddDTO.getSize())
                .ext(roomImgAddDTO.getExt())
                .build();

        ROOMIMGREPOSITORY.save(roomImg);
    }
}
