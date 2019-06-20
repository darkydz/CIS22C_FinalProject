//package finalProject;
//
//public class Professor implements Comparable<Professor> {
//    private String username;
//    private String password;
//    private String name;
//    private String phone;
//
//    public Professor() {
//        username = "";
//        password = "";
//        name = "";
//        phone = "";
//    }
//
//    public Professor(String username, String password,String name, String address,String city,
//                    String state, int zip, String phone) {
//        this.username = username;
//        this.password = password;
//        this.name = name;
//        this.phone = phone;
//    }
//
//    public String getUserName() {
//        return username;
//    }
//
//    public String getPassWord(){
//        return password;
//    }
//    public String getName() {
//        return name;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//
//    public void setUserName(String username) {
//        this.username = username;
//    }
//
//    public void setPassWord(String password) {
//        this.password = password;
//    }
//
//    public void setFirstName(String name) {
//        this.name = name;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//
//    @Override public int hashCode() {
//        String key = name;
//        int sum = 0;
//        for(int i = 0; i < key.length();i++) {
//            sum += (int) key.charAt(i);
//        }
//        return sum;
//    }
//
//    /**
//     * Determines whether two Customer objects are
//     * equal by comparing firstName,lastName and phone
//     * @param o the second Customer object
//     * @return whether the Customer are equal
//     */
//    @Override public boolean equals(Object o) {
//        if(o == this) {
//            return true;
//        }else if(!(o instanceof Customer)) {
//            return false;
//        }else {
//            Customer m = (Customer) o;
//            if(m.name.equals(this.name) && m.phone.equals(this.phone)) {
//                return true;
//            }
//            return false;
//        }
//    }
//
//	@Override
//	public int compareTo(Professor otheremployes) {
//		if(this.name.equals(otheremployes.name) && this.phone.equals(otheremployes.phone)) {
//			return 0;
//		} else if(this.name.equals(otheremployes.name)) {
//			if(this.phone.compareTo(otheremployes.phone) < 0) {
//				return -1;
//				}else {
//					return 1;
//					}
//			}else {
//				if(this.name.equals(otheremployes.name)) {
//					return this.name.compareTo(otheremployes.name);
//					}else {
//						return this.name.compareTo(otheremployes.name);
//						}
//				}
//	}
//}
