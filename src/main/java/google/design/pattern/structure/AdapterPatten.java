package google.design.pattern.structure;

public class AdapterPatten {
    public abstract class CarController{
        public void move(){
            System.out.println("玩具汽车移动");
        }
        public abstract void phonate();//发出声音
        public abstract void winkle();//灯光闪烁
    }

    //Adaptee PoliceSound
    public class PoliceSound{
        public void alarmSound() {
            System.out.println("发出警笛声音");
        }
    }
    //Adaptee PoliceLamp
    public class PoliceLamp{
        public void alarmLamp(){
            System.out.println("灯光闪烁");
        }
    }
    public class PoliceCarAdapter extends CarController{
        private PoliceSound policeSound;
        private PoliceLamp policeLamp;

        public PoliceCarAdapter(PoliceSound policeSound, PoliceLamp policeLamp) {
            this.policeSound = policeSound;
            this.policeLamp = policeLamp;
        }

        @Override
        public void phonate() {
            policeSound.alarmSound();
        }

        @Override
        public void winkle() {
            policeLamp.alarmLamp();
        }
    }
}
