##各类的解释

* Stop.java
这个类定义了火车停靠的站台，变量有站台ID，和该站到下一站的时长

* Journey.java
这个类中包涵一个承载Stop对象的ArrayList,另外还有Journey对象的ID，Journey对象从central station 出发的时间，和一个Iterator（用于print出来所有Stop）

* Route.java
Route类中变量有Route对象的名称，route的ID，和一个承载Journey对象的ArrayList
