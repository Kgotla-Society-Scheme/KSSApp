package za.co.kss.app.config;

public class JwtGenerator {
    /* Used for roken generation*/



   /* @Autowired

    private  AppUserRepository appUserRepository;



    public static void main(String[]args){



        try {

            System.out.print(new Main().login());

        } catch (IOException e) {

            e.printStackTrace();

        }

    }



    public  ResponseEntity<Map<String, Object>> login() throws IOException {

        String token = null;

        List<String> roles = new ArrayList<>();

        roles.add("ADMIN");

        Map<String, Object> tokenMap = new HashMap<String, Object>();

            token = Jwts.builder().setSubject("admin").claim("roles", roles).setIssuedAt(new Date())

                    .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

            tokenMap.put("token", token);



            return new ResponseEntity<Map<String, Object>>(tokenMap, HttpStatus.OK);



    }*/
}
