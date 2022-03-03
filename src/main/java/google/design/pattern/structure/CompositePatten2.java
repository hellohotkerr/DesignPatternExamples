package google.design.pattern.structure;

import java.util.ArrayList;

public class CompositePatten2 {
    public abstract class AbstractFile{
        public abstract void killVirus();
    }
    public class ImageFile extends AbstractFile{
        private String name;

        public ImageFile(String name) {
            this.name = name;
        }

        @Override
        public void killVirus() {
            //模拟杀毒
        }
    }
    public class TextFile extends AbstractFile{
        private String name;

        public TextFile(String name) {
            this.name = name;
        }

        @Override
        public void killVirus() {
            //模拟杀毒
        }
    }

    public class VideoFile extends AbstractFile{
        private String name;

        public VideoFile(String name) {
            this.name = name;
        }

        @Override
        public void killVirus() {
            //模拟杀毒
        }
    }
    public class Folder extends AbstractFile{
        private String name;
        private ArrayList<AbstractFile> list = new ArrayList<>();

        public Folder(String name) {
            this.name = name;
        }

        public void add(AbstractFile file) {
            list.add(file);
        }

        public void remove(AbstractFile file) {
            list.remove(file);
        }

        public AbstractFile getChild(int i) {
            return list.get(i);
        }

        @Override
        public void killVirus() {
            for (AbstractFile abstractFile : list) {
                abstractFile.killVirus();
            }
        }
    }
}
