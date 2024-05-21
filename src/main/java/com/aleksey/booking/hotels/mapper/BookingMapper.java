package com.aleksey.booking.hotels.mapper;

import com.aleksey.booking.hotels.api.response.BookingListResponse;
import com.aleksey.booking.hotels.api.response.BookingResponse;
import com.aleksey.booking.hotels.api.request.UpsertBookingRequest;
import com.aleksey.booking.hotels.model.Booking;
import com.aleksey.booking.hotels.model.Room;
import org.mapstruct.*;

import java.util.List;

@DecoratedWith(BookingMapperDelegate.class)
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookingMapper {
    Booking toEntity(UpsertBookingRequest upsertBookingRequest, List<Room> rooms);

    BookingResponse toDto(Booking booking);

    List<BookingResponse> bookingListToResponseList(List<Booking> bookings);

    default BookingListResponse bookingListToBookingListResponse(List<Booking> bookings) {
        return new BookingListResponse(bookingListToResponseList(bookings));
    }
}