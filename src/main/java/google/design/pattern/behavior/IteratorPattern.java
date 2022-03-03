package google.design.pattern.behavior;

import java.util.ArrayList;
import java.util.List;

public class IteratorPattern {
    public abstract class AbstractObjectList{
        protected List<Object> objects = new ArrayList<>();

        public AbstractObjectList(List<Object> objects) {
            this.objects = objects;
        }
        public void addObject(Object obj){
            objects.add(obj);
        }
        public void removeObject(Object obj){
            objects.remove(obj);
        }
        public List<Object> getObjects(){
            return objects;
        }
        public abstract AbstractIterator createIterator();
    }
    public class ProductList extends AbstractObjectList{

        public ProductList(List<Object> objects) {
            super(objects);
        }

        @Override
        public AbstractIterator createIterator() {
            return new ProductIterator(this);
        }

    }
    public interface AbstractIterator{
        public void next();
        boolean isLast();
        void previous();
        boolean isFirst();
        Object getNextItem();
        Object getPreviousItem();
    }
    public class ProductIterator implements AbstractIterator{
        private List<Object> products;
        private int cursor1;
        private int cursor2;

        public ProductIterator(ProductList productList) {
            this.products = productList.getObjects();
            cursor1 = 0;
            cursor2 = this.products.size()-1;
        }

        @Override
        public void next() {
            if (cursor1 < products.size()-1) {
                cursor1++;
            }
        }

        @Override
        public boolean isLast() {
            return (cursor1 == products.size()-1);
        }

        @Override
        public void previous() {
            if (cursor2 > 0) {
                cursor2 --;
            }
        }

        @Override
        public boolean isFirst() {
            return cursor2 == 0;
        }

        @Override
        public Object getNextItem() {
            return products.get(cursor1);
        }

        @Override
        public Object getPreviousItem() {
            return products.get(cursor2);
        }
    }
}
