package com.bzdgs.dms.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.EnumSet;

public class SshUtil {
    
    public void uploadSFTP(String localPath, String remotePath) throws IOException {
        SshClient client = SshClient.setUpDefaultClient();
        client.start();
        ClientSession session = client.connect("user", "10.10.20.20", 22).verify().getSession();
        session.addPasswordIdentity("password");
        session.auth().verify();

        SftpClientFactory factory = SftpClientFactory.instance();
        SftpClient sftp = factory.createSftpClient(session);

        SftpClient.CloseableHandle handle = sftp.open(remotePath,
                EnumSet.of(SftpClient.OpenMode.Write, SftpClient.OpenMode.Create));
        FileInputStream in = new FileInputStream(localPath);
        int buff_size = 1024 * 1024;
        byte[] src = new byte[buff_size];
        int len;
        long fileOffset = 0l;
        while ((len = in.read(src)) != -1) {
            sftp.write(handle, fileOffset, src, 0, len);
            fileOffset += len;
        }

        in.close();
        sftp.close(handle);

        session.close(false);
        client.stop();
    }
}
