package pandox.china.dto.enums;

public enum HeroType {

//    DK = 16
//    ELF = 32
//    WIZ = 0
//    MG = 48
//    DL = 64
//    SUM = 80
//    RF = 96

    DK(16),
    ELF(32),
    SM(0),
    SU(80),
    RF(96),
    DL(64),
    MG(48);

    private int type;

    HeroType(int type) {

        this.type = type;
    }


    public static HeroType valueOf(int type) {
        for (HeroType heroType : HeroType.values()) {
            if (heroType.type == type) {
                return heroType;
            }
        }

        return HeroType.DK;
    }


}
