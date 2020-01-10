package com.mj.myvedio.service.pattern;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class TestObserver {

    public static void main(String[] args) {
        MyObservable observable = new MyObservable();
        observable.addObserver(new TestObserver.TObserver("observer0001"));
        observable.addObserver(new TestObserver.TObserver("observer0022"));
        observable.addObserver(new TestObserver.TObserver("observer0333"));
        observable.addObserver(new TestObserver.TObserver("observer4444"));

        observable.setChanged();

        TmpEntity tmpEntity = new TmpEntity();
        tmpEntity.setName("SYSTEM");
        tmpEntity.setPassword("123456");
        observable.notifyObservers(tmpEntity);
    }


    interface MyObserver{
        void update(MyObservable o, Object arg);
    }

   static class TObserver implements MyObserver{

        private String message;

        TObserver(String msg){
            this.message = msg;
        }

        @Override
        public void update(MyObservable o, Object arg) {
            if(arg != null && arg instanceof TmpEntity){
                TmpEntity entity = (TmpEntity)arg;
                System.out.println("[ " + message +" ] 收到通知: arg=[" + entity.toString() + "]");
            }else{
                System.out.println("[ " + message +" ] 收到通知: arg=null");
            }
        }
    }

    static class TmpEntity {
        private String name;
        private String password;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "TmpEntity{" +
                    "name='" + name + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}
