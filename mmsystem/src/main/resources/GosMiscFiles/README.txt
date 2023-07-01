
MmsUser
========
MmsUser & MmsUserDTO are being used. There are additional fields in DTO in case we don't want to send
the full user status and role object with the DTO but Ids. Changed my mind.


Security For MMService
========================
I have implemented a custom security module which uses the user in the MMService.
Spring boot security workflow looks as follows
1)Filters - Extract user credentials from http request header and put it in security context
2AuthenticationManager ====> The default spring boot's is being used
3)CustomAuthenticationProvider which does authenticate user against customuserdetailservice
4)CustomUserDetialService which is being used by custom authenticationprovider, gets the user information from MMService
5)putting all together under configuration ====> customsecurityconfig
6)CustomSecurityConfig ====> 
	=>Sets up password encoder bean
	=>AuthManager
	=>filterchain --for cors, session, request auth,
7)The customeuserdetailservice ===> uses BCryptPasswordEncoder to encode the password and save it to MMService
8)The CustomAuthenticationProvider==> uses BCryptPasswordEncoder to decode the password before checking for authentication
		==> The customauthenticationprovider get set the encoder automatically from the configuration
		
		Do not encode the Raw Password. Suppose rawPassword is the password that client gave you and encodedPassword is the encoded stored password in the database. Then, instead of encoding the rawPassword and comparing the result using String#equals, use the PasswordEncoder#matches method:

PasswordEncoder passwordEnocder = new BCryptPasswordEncoder();
if (passwordEncoder.matches(rawPassword, encodedPassword)) {
    System.out.println("Matched!");
}