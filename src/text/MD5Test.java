import com.aifyun.aiyun.dto.UserDTO;
import com.aifyun.aiyun.utils.MD5Utils;
import com.aifyun.aiyun.utils.UUIDUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Random;
import java.util.UUID;


public class MD5Test {

    public static void main(String args[]) {
        System.out.println(MD5Utils.MD5(UUIDUtils.getUUID()));
    }

}

