package iwm2016.telemd.consultation.domain;

import iwm2016.telemd.consultation.exception.ActionException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author kaminsj7
 */
public enum ActionType {

    ENTER_SESSION(),

    EXIT_SESSION(),

    SHOW_IMAGE("image", "x", "y", "r", "s"),

    HIDE_IMAGE("image"),

    MOVE_IMAGE("x", "y", "r", "s"),

    DRAW("path"),

    ADD_COMMENT("comment");

    private String[] requiredKeys;

    ActionType(String... requiredKeys) {
        this.requiredKeys = requiredKeys;
    }

}
