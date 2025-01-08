package Tests.RestfulBookerAPI;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class createResponse {
    private int bookingid;
    private Booking booking;

    private BookingDates bookingdates;

    @Data
    public static class Booking {
        private String firstname;
        private String lastname;
        private int totalprice;
        private boolean depositpaid;
        private BookingDates bookingdates;
        private String additionalneeds;
    }

        @Data
        public static class BookingDates{
            private String checkin;
            private String checkout;
        }
}
