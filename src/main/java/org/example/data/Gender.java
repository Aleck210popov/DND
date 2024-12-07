package org.example.data;

public enum Gender implements Attr {
    MALE {
        @Override
        public String getDescription() {
            return "Мужчина — пол, традиционно ассоциируемый с мужскими ролями и обязанностями.";
        }
    },
    FEMALE {
        @Override
        public String getDescription() {
            return "Женщина — пол, традиционно ассоциируемый с женскими ролями и обязанностями.";
        }
    };
}
