package google.design.pattern.construct;

import java.io.*;

public class PrototypePattern {
    public class Attachment{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public void download(){
            System.out.println("download attachment name is "+name);
        }
    }
    //浅复制
    public class WeekLog implements  Cloneable{
        private Attachment attachment;
        private String name;
        private String date;
        private String content;

        public Attachment getAttachment() {
            return attachment;
        }

        public void setAttachment(Attachment attachment) {
            this.attachment = attachment;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public WeekLog clone(){
            Object object = null;
            try {
                object = super.clone();
                return (WeekLog) object;
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                System.out.println("不支持复制");
                return null;
            }
        }
    }

    //通过序列化实现深复制
    public class AttachmentDeepCopy implements Serializable {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public void download(){
            System.out.println("download attachment name is "+name);
        }
    }
    public class WeekLogDeepCopy implements  Serializable{
        private Attachment attachment;
        private String name;
        private String date;
        private String content;

        public Attachment getAttachment() {
            return attachment;
        }

        public void setAttachment(Attachment attachment) {
            this.attachment = attachment;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public WeekLog deepClone() throws IOException, ClassNotFoundException {
           //将对象写入流中
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bao);
            oos.writeObject(this);
            //将对象从流中取出
            ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (WeekLog) ois.readObject();
        }
    }
}
