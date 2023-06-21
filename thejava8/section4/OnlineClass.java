package thejava8.section4;

import java.util.Optional;

public class OnlineClass {
    private Integer id;
    private String title;
    private boolean closed;

    private Progress progress;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Optional<Progress> getProgress() {
        return Optional.ofNullable(progress);
    }
//    public void setProgress(Progress progress) {
//        this.progress = progress;
//    }


    // 사용할 순 있지만 권장은 아님
    public void setProgress(Optional<Progress> progress) {
        progress.ifPresent(o ->{
            progress.ifPresent(p -> this.progress = p);
        });

    }

}
