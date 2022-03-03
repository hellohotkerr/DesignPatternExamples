package google.design.pattern.structure;

public class BridgePatten {
    public interface Implementor{
        public void operarionImpl();
    }
    public class ConcreteImplementor implements Implementor{

        @Override
        public void operarionImpl() {
            //detail...
        }
    }

    public abstract class Abstraction{
        protected  Implementor impl;

        public void setImpl(Implementor impl) {
            this.impl = impl;
        }

        public abstract void operation();
    }
    public class RefineAbstraction extends Abstraction{

        @Override
        public void operation() {
            //...
            if (impl != null) {
                impl.operarionImpl();
            }
            //..
        }
    }


    public class Matrix{

    }
    public interface ImageImp{
        public void doPaint(Matrix matrix);//显示像素矩阵
    }
    public class WindowsImp implements ImageImp{

        @Override
        public void doPaint(Matrix matrix) {
            //windows paint
        }
    }
    public class LinuxImp implements ImageImp{

        @Override
        public void doPaint(Matrix matrix) {
            //linux paint
        }
    }
    public class UnixImp implements ImageImp{

        @Override
        public void doPaint(Matrix matrix) {
            //unix paint
        }
    }
    public abstract class Image{
        protected ImageImp imp;

        public void setImp(ImageImp imp) {
            this.imp = imp;
        }
        public abstract void parseFile(String fileName);
    }
    public class JPEGImage extends Image{

        @Override
        public void parseFile(String fileName) {
            //模拟JPEG
            Matrix matrix = new Matrix();
            imp.doPaint(matrix);
        }
    }
    public class PNGImage extends Image{

        @Override
        public void parseFile(String fileName) {
            //模拟PNG
            Matrix matrix = new Matrix();
            imp.doPaint(matrix);
        }
    }
    public class BMPImage extends Image{

        @Override
        public void parseFile(String fileName) {
            //模拟BMP
            Matrix matrix = new Matrix();
            imp.doPaint(matrix);
        }
    }
    public class GIFImage extends Image{

        @Override
        public void parseFile(String fileName) {
            //模拟GIF
            Matrix matrix = new Matrix();
            imp.doPaint(matrix);
        }
    }
}

