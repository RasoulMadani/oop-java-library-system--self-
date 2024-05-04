package publicClasses;

import java.util.Arrays;

public class ArrayOfObjects {
    public  Object[] data;
     int size = 2;
     int index = 0;
     public ArrayOfObjects(){
         this.data = new Object[size];
     }
     public void add(Object object){
         if(index >= data.length){
             Object[] newData = new Object[index*2];
             System.arraycopy(data, 0, newData, 0, this.data.length);
             this.data = newData;
             this.data[index] = object;
         }else{
             this.data[index] = object;

         }
         index++;

     }
    public Object[] get(){
         return data;
    }
    public Object get(int i){
         return this.data[i];
    }
    @Override
    public String toString() {
        return "ArrayOfObjects{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", index=" + index +
                '}';
    }
}
