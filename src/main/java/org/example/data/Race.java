package org.example.data;

public enum Race implements Attr {
    ORC {
        @Override
        public String getDescription() {
            return "Огры — большие и сильные существа, обычно враждебные.";
        }
    },
    ELF {
        @Override
        public String getDescription() {
            return "Эльфы — магические и долговечные существа, часто считаются мудрыми.";
        }
    },
    DARK_ELF {
        @Override
        public String getDescription() {
            return "Тёмные эльфы — существа, известные своей скрытностью и агрессией.";
        }
    },
    DRACONBORN {
        @Override
        public String getDescription() {
            return "Тёмные эльфы — существа, известные своей скрытностью и агрессией.";
        }
    },
    HUMAN {
        @Override
        public String getDescription() {
            return "Тёмные эльфы — существа, известные своей скрытностью и агрессией.";
        }
    },
    AASIMAR {
        @Override
        public String getDescription() {
            return "Тёмные эльфы — существа, известные своей скрытностью и агрессией.";
        }
    };
}
