package google.design.pattern.structure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FacadePatten {
    public class FileReader {
        public String read(String fileNameSrc) {
            System.out.println("读取文件，获取明文 ");
            StringBuffer sb = new StringBuffer();
            try {
                FileInputStream inFS = new FileInputStream(fileNameSrc);
                int data;
                while (true) {
                    if (!((data = inFS.read()) != -1)) {
                        sb = sb.append(data);
                    }
                    inFS.close();
                }
            } catch (FileNotFoundException e) {
                System.out.println("文件不存在 " );

            } catch (IOException e) {
                System.out.println("文件操作错误 " );
            }
            return sb.toString();
        }
    }

    public class CipherMachine{
        public String encrypt(String plainText){
            System.out.println("数据加密模拟，将明文转换为密文" );
            String es = "";
            for (int i = 0; i < plainText.length(); i++) {
                String c = String.valueOf(plainText.charAt(i) % 7);
                es +=c;
            }
            return es;
        }
    }
    public class FileWriter{
        public void write(String encryptStr,String fileNameDes) {
            System.out.println("保存密文，写入文件 ");
            try {
                FileOutputStream outFS = new FileOutputStream(fileNameDes);
                outFS.write(encryptStr.getBytes());
                outFS.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("文件不存在 " );
            }catch (IOException e) {
                e.printStackTrace();
                System.out.println("文件操作错误 " );
            }

        }
    }

    public class EncryptFacade{
        private FileReader reader;
        private CipherMachine cipherMachine;
        private FileWriter writer;

        public EncryptFacade() {
            reader = new FileReader();
            cipherMachine = new CipherMachine();
            writer = new FileWriter();
        }
        public void fileEncrypt(String fileNameSrc,String fileNameDes){
            String plainSrc = reader.read(fileNameSrc);
            String encryptStr = cipherMachine.encrypt(plainSrc);
            writer.write(encryptStr, fileNameDes);
        }
    }

}
