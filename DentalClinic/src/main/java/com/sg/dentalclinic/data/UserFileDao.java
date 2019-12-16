package com.sg.dentalclinic.data;

import com.sg.dentalclinic.models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserFileDao
        extends FileDao<User>
        implements UserDao{

    public UserFileDao(String path) {
        super(path, 3, false);
    }

    @Override
    public List<User> findAll() {
        try {
            return read(this::mapToUser).stream()
                    .collect(Collectors.toList());
        } catch (StorageException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public User find(int ID) {
        return findAll().stream()
            .filter(a -> a.getID() == ID)
            .findFirst()
            .orElse(null);
    }

    @Override
    public void add(User arg) throws StorageException {
        append(arg, this::mapToString);
    }

    @Override
    public boolean update(int ID, User arg) throws NotFoundException, StorageException {
        List<User> users = findAll();

        User user = users.get(ID);
        if(user == null){
            throw new NotFoundException("user not found.");
        }
        
        users.set(ID, user);
        write(users, this::mapToString);
        return true;
    }

    @Override
    public boolean delete(int ID) throws NotFoundException, StorageException {
        User user = find(ID);
        if(user == null){
            throw new NotFoundException("user not found.");
        }
        List<User> users = findAll();
        users.remove(ID);
        
        write(users, this::mapToString);
        
        return true;
    }
    
    private String mapToString(User user) {
        return String.format("%s,%s,%s",
                user.getID(),
                user.getFirstName(),
                user.getLastName()
        );
    }

    private User mapToUser(String[] tokens) {
        return new User(
                Integer.parseInt(tokens[0]),
                tokens[1],
                tokens[2]
        );
    }
}
