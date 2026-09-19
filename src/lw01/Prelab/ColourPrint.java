
public class ColourPrint extends PrintJob {

    private static final int FIRST_TIER_LIMIT = 10;
    private static final int FIRST_TIER_RATE = 1500;
    private static final int EXTRA_RATE = 1000;
    private static final int SETUP_FEE = 2000;

    public ColourPrint(String id, int pages) {
        super(id, pages);
    }

    @Override
    public int calculateCharge() {
        int pages = getPages();
        int firstTierPages = Math.min(pages, FIRST_TIER_LIMIT);
        int extraPages = Math.max(pages - FIRST_TIER_LIMIT, 0);
        return (firstTierPages * FIRST_TIER_RATE) + (extraPages * EXTRA_RATE) + SETUP_FEE;
    }

    @Override
    public String label() {
        return "Colour";
    }
}
