package peaksoft.lmsprojectjava14.service;

import peaksoft.lmsprojectjava14.entity.Company;
import peaksoft.lmsprojectjava14.entity.Group;

import java.util.List;

public interface GroupService {

    void saveGroup(Group group);
    List<Group> getAllGroup();
    Group getGroupById(Long id);
    void updateGroupById(Long oldGroup,Group newGroup);
    void deleteGroupById(Long id);
}
