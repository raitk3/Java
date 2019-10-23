package ee.taltech.iti0202.socialnetwork;
import ee.taltech.iti0202.socialnetwork.feed.Feed;
import ee.taltech.iti0202.socialnetwork.group.Group;
import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.LinkedHashSet;
import java.util.Set;

public class SocialNetwork {
    private Set<Group> groups;
    private Set<Message> messages;

    public SocialNetwork() {
        this.groups = new LinkedHashSet<>();
        this.messages = new LinkedHashSet<>();
    }

    public void registerGroup(Group group) {
        this.groups.add(group);
    }

    public Set<Group> getGroups() {
        return this.groups;
    }

    public Feed getFeedForUser(User user) {
        for (Group group: this.groups) {
            if (group.getParticipants().contains(user)) {
                this.messages.addAll(group.getMessages());
            }
        }
        return new Feed(user, messages);
    }

}
