package org.example.data;

public enum PlayerClass implements Attr {
    KNIGHT {
        @Override
        public String getDescription() {
            return "Рыцарь — сильный и защитный класс, специализирующийся на мечах и броне.";
        }
    },
    PALADIN {
        @Override
        public String getDescription() {
            return "Паладин — защитник добра и справедливости, обладающий магией и высокой выносливостью.";
        }
    },
    MAGE {
        @Override
        public String getDescription() {
            return "Маг — владеет мощной магией, но слаб в физическом плане.";
        }
    },
    WARRIOR {
        @Override
        public String getDescription() {
            return "Маг — владеет мощной магией, но слаб в физическом плане.";
        }
    };
}
