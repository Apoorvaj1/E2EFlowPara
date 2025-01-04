package utils;

public class Payload {


    public static String getPayload(String first,String last,int price){
        String payload = "{\n" +
                "    \"firstname\" : \""+first+"\",\n" +
                "    \"lastname\" : \""+last+"\",\n" +
                "    \"totalprice\" : "+price+",\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
                return payload;
    }
    public static String payloadPUT(String first,String last,int price,boolean bool){
        String payload = "{\n" +
                "    \"firstname\" : \""+first+"\",\n" +
                "    \"lastname\" : \""+last+"\",\n" +
                "    \"totalprice\" : "+price+",\n" +
                "    \"depositpaid\" : "+bool+",\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        return payload;
    }
}
