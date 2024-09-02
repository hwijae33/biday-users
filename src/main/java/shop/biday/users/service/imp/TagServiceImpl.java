package shop.biday.users.service.imp;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.biday.users.model.entity.Tag;
import shop.biday.users.model.domain.TagDto;
import shop.biday.users.model.repository.TagRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TagServiceImpl {

    private final TagRepository TAGREPOSITORY;

    public List<TagDto> list() {

        List<Tag> tags = TAGREPOSITORY.findAll();

        return tags.stream()
                .map(tag -> TagDto.builder()
                        .id(tag.getId())
                        .name(tag.getName())
                        .PN(tag.getPN())
                        .build())
                .collect(Collectors.toList());

    }
}

