public class Item{
 byte data;
 Item previous;
 Item next;
 
 public Item(byte d){
   data = d;
   previous = null;
   next = null;
 }
 
 public Item(int i){
   this((byte)i);
 }
 
 public Item getPrevious(){
   return previous;
 }
 
 public Item getNext(){
   return next;
 }
 
 public byte getData(){
   return data;
 }
 
 public void setPrevious(Item prev){
   previous = prev;
 }
 
 public void setNext(Item n){
  next = n; 
 }
 
 public void setData(byte d){
   data = d;
 }
}