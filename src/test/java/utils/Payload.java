package utils;

public class Payload {


    public static String getPayload(String first,String last){
        String payload = "{\n" +
                "    \"firstname\" : \""+first+"\",\n" +
                "    \"lastname\" : \""+last+"\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
                return payload;
    }
}
