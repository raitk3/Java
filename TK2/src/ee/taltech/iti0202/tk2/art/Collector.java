package ee.taltech.iti0202.tk2.art;

import java.util.ArrayList;
import java.util.List;

public class Collector {

    private List<Painting> paintings;
    private List<String> paintingTitles;

    public Collector() {
        this.paintings = new ArrayList<>();
        this.paintingTitles = new ArrayList<>();
    }

    public boolean addPainting(Painting painting) {
        if (!this.paintings.contains(painting) && !this.paintingTitles.contains(painting.getTitle())) {
            this.paintings.add(painting);
            this.paintingTitles.add(painting.getTitle());
            painting.owner = this;
            return true;
        }
        return false;
    }

    public boolean sellPainting(Painting painting, Collector fellowCollector) {
        if (!fellowCollector.paintings.contains(painting)
                && !fellowCollector.paintingTitles.contains(painting.getTitle())
                && painting.owner != null && fellowCollector != painting.owner) {
            painting.owner.paintings.remove(painting);
            this.paintings.add(painting);
            this.paintingTitles.add(painting.getTitle());
            painting.owner = this;
            return true;
        }
        return false;
    }

    public List<Painting> getPaintings() {
        return this.paintings;
    }
}
