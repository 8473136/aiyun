import com.aifyun.aiyun.dto.UserDTO;
import com.aifyun.aiyun.utils.MD5Utils;
import com.aifyun.aiyun.utils.UUIDUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;


public class MD5Test {

    public static void main(String args[]) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId("11");
        System.out.println(userDTO.getId());

    }

}

