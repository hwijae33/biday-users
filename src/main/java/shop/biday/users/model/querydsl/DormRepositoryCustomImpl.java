package shop.biday.users.model.querydsl;


import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.biday.users.model.domain.RoomDTO;
import shop.biday.users.model.entity.QBooking;
import shop.biday.users.model.entity.QDorm;
import shop.biday.users.model.entity.QRoom;
import shop.biday.users.model.entity.QUserEntity;

import java.util.List;

@Repository
public class DormRepositoryCustomImpl implements DormRepositoryCustom {

    @Autowired
    private JPAQueryFactory queryFactory;

    @Override
    public List<DormBookingListDTO> findBookingsBySellerId(Long userId) {
        QDorm dorm = QDorm.dorm;
        QRoom room = QRoom.room;
        QBooking booking = QBooking.booking;
        QUserEntity user = QUserEntity.userEntity;

        return queryFactory
                .select(Projections.constructor(DormBookingListDTO.class,
                        dorm.id,
                        dorm.name,
                        dorm.address,
                        dorm.status,
                        Projections.constructor(RoomDTO.class,
                                room.id,
                                room.name,
                                room.type),
                        Projections.constructor(DormBookingDTO.class,
                                booking.id,
                                booking.checkIn,
                                booking.checkOut,
                                user.name)))
                .from(dorm)
                .join(dorm.rooms, room)
                .join(room.bookings, booking)
                .join(booking.users, user)
                .where(dorm.user.id.eq(userId))
                .fetch();
    }
}