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
    public static boolean hasPermission(User user, Role role){
        boolean hasPermission = true;
        if(user.getRoles().size() == 0){
            hasPermission = true;
        }
        for (Role s : user.getRoles()){
            if(role.getLevel() == s.getLevel() ||
                     s.getLevel() == 3 || role.getLevel() == 3){
                    hasPermission = false;
                }
            }
        return hasPermission;
    }
}
