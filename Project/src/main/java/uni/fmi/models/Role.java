package uni.fmi.models;

import java.util.Set;

public class Role {

	private String roleName;
	private Set<User> users;
	
    public Role(String roleName) {
    	this.roleName = roleName;
    }

    public Role() {
		// TODO Auto-generated constructor stub
	}

	public String getUserRole() {
        return roleName;
    }

    public void setUserRole(String userRole) {
        this.roleName = userRole;
    }

    public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Role other = (Role) obj;
		if (roleName == null) {
			if (other.roleName != null) {
				return false;
			}
		} else if (!roleName.equals(other.roleName)) {
			return false;
		}
		return true;
	}
}