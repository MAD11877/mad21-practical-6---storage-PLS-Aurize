package sg.edu.np.mad.madapplication;




public class user {
    private String name;
    private String description;
    private int id;
    private boolean followed; // alt + insert for easy constructor and getter setter. Rmbr to select which properties want teh constructor and getter setter



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }

    public user() {}



    public user(String Name, String Description, int id, boolean followed){
        this.name = Name;
        this.description = Description;
        this.id = id;
        this.followed = followed;
    }

}

