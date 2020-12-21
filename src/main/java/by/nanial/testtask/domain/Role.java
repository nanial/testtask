package by.nanial.testtask.domain;

public enum Role {
    USER (1), CUSTOMER(1), ADMIN (2), PROVIDER(2), SUPER_ADMIN (3);
    private final int level;
    Role(int level) {
        this.level = level;
    }
    public int getLevel() {
        return this.level;
    }

    public static boolean contains(String role){
        boolean isContain = false;
        for (Role s : Role.values()){
            if(s.toString().equals(role)){
                isContain = true;
            }
        }
        return isContain;
    }
    public static boolean permission(Role role){
        boolean hasPermission = false;
        for (Role s : Role.values()){
            if(s.getLevel() != role.getLevel() && s.getLevel() != 3){//change conditions
                hasPermission = true;
            }
        }
        return hasPermission;
    }
}
