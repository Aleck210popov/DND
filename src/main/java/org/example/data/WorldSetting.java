package org.example.data;

public enum WorldSetting implements Attr{
    FANTASY {
        @Override
        public String getDescription() {
            return "Фэнтези мир с магией и фантастическими существами.";
        }
    },
    DARK_FANTASY {
        @Override
        public String getDescription() {
            return "Тёмное фэнтези с мрачными и жестокими элементами.";
        }
    },
    SCI_FY {
        @Override
        public String getDescription() {
            return "Мир науки и технологий, будущие технологии и космос.";
        }
    },
    CYBERPUNK {
        @Override
        public String getDescription() {
            return "Киберпанк с высокими технологиями и низким качеством жизни.";
        }
    };
}
