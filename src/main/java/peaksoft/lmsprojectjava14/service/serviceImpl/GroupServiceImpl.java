package peaksoft.lmsprojectjava14.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.lmsprojectjava14.entity.Course;
import peaksoft.lmsprojectjava14.entity.Group;
import peaksoft.lmsprojectjava14.repository.CourseRepository;
import peaksoft.lmsprojectjava14.repository.GroupRepository;
import peaksoft.lmsprojectjava14.service.GroupService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {


    private final GroupRepository groupRepository;
    private final CourseRepository courseRepository;
    @Override
    public void saveGroup(Group group) {
        groupRepository.save(group);

    }

    @Override
    public List<Group> getAllGroup() {
        return groupRepository.findAll();
    }

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.findById(id).orElseThrow(
                ()-> new NoSuchElementException(
                        "Group with id" + id + "not found"
                )
        );
    }

    @Override
    public void updateGroupById(Long oldGroup, Group newGroup) {
        Group group = getGroupById(oldGroup);
        group.setGroupName(newGroup.getGroupName());
        group.setImageLink(newGroup.getImageLink());
        group.setDescription(newGroup.getDescription());
        groupRepository.save(group);

    }

    @Override
    public void deleteGroupById(Long id) {
        if (groupRepository.existsById(id)){
            groupRepository.deleteById(id);
        }else {
            throw new NoSuchElementException(
                    "Group with id" + id + "not found"
            );
        }
        groupRepository.deleteById(id);

    }

    //method

    public Group createGroupWithCourses(Group group, List<Long> courseIds) {
        List<Course> courses = courseRepository.findAllById(courseIds);
        group.getCourses().addAll(courses);
        return groupRepository.save(group);
    }
}
