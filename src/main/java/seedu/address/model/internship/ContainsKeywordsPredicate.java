package seedu.address.model.internship;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that an {@code Internship}'s {@code Company} matches any of the keywords given.
 */
public class ContainsKeywordsPredicate implements Predicate<Internship> {
    private final List<String> keywords;

    /**
     * Constructs a new ContainsKeywordsPredicate.
     *
     * @param keywords List of keywords.
     */
    public ContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Internship internship) {
        return keywords.stream()
                .anyMatch(keyword -> (StringUtil.containsWordIgnoreCase(internship.getCompany().value, keyword)
                        || internship.getTags().stream().anyMatch(tag -> StringUtil.containsWordIgnoreCase(
                                tag.tagName, keyword))));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((ContainsKeywordsPredicate) other).keywords)); // state check
    }

}
