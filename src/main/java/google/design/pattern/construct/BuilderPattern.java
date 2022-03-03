package google.design.pattern.construct;

public class BuilderPattern {
    public class Actor{
        private String type;
        private String sex;
        private String face;
        private String costume;
        private String hairStyle;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public String getCostume() {
            return costume;
        }

        public void setCostume(String costume) {
            this.costume = costume;
        }

        public String getHairStyle() {
            return hairStyle;
        }

        public void setHairStyle(String hairStyle) {
            this.hairStyle = hairStyle;
        }
    }

    public abstract class ActorBuilder{
        protected Actor actor = new Actor();
        public abstract  void buildType();
        public abstract  void buildSex();
        public abstract  void buildFace();
        public abstract  void buildCostume();
        public abstract  void buildHairStyle();

        public Actor createActor(){
            return actor;
        }
    }
    public class HeroBuilder extends ActorBuilder{

        @Override
        public void buildType() {
            actor.setType("Hero");
        }

        @Override
        public void buildSex() {
            actor.setSex("MAN");
        }

        @Override
        public void buildFace() {
            actor.setFace("Handsome");
        }

        @Override
        public void buildCostume() {
            actor.setCostume("盔甲");
        }

        @Override
        public void buildHairStyle() {
            actor.setHairStyle("飘逸");
        }
    }

    public class AngleBuilder extends ActorBuilder{

        @Override
        public void buildType() {
            actor.setType("Angle");
        }

        @Override
        public void buildSex() {
            actor.setSex("WOMAN");
        }

        @Override
        public void buildFace() {
            actor.setFace("Beauty");
        }

        @Override
        public void buildCostume() {
            actor.setCostume("白裙");
        }

        @Override
        public void buildHairStyle() {
            actor.setHairStyle("披肩长发");
        }

        public class DevilBuilder extends ActorBuilder{

            @Override
            public void buildType() {
                actor.setType("Devil");
            }

            @Override
            public void buildSex() {
                actor.setSex("妖");
            }

            @Override
            public void buildFace() {
                actor.setFace("丑陋");
            }

            @Override
            public void buildCostume() {
                actor.setCostume("黑衣");
            }

            @Override
            public void buildHairStyle() {
                actor.setHairStyle("光头");
            }
        }
    }

    public class ActorController{
        public Actor constructActor(ActorBuilder builder) {
            Actor actor;
            builder.buildType();
            builder.buildSex();
            builder.buildFace();
            builder.buildCostume();
            builder.buildHairStyle();
            actor = builder.createActor();
            return actor;
        }
    }

}
