package platform.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.SECONDS;


@ToString
@EqualsAndHashCode
@Entity
public final class CodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 1000)
    private String code;
    @CreationTimestamp
    @JsonProperty("date")
    private LocalDateTime creationDate;
    @JsonProperty("views")
    private long views;
    private long time;
    //used in JPA derived query
    private boolean isLimited = false;
    private boolean isTimeLimited;
    private boolean isViewsLimited;
    public CodeEntity() {

    }

    @JsonCreator
    public CodeEntity(String id, String code, long views, long time) {
        this.id = id;
        this.code = code;
        this.views = views;
        this.time = time;
        this.isTimeLimited = time > 0;
        this.isViewsLimited = views > 0;
        this.isLimited = isTimeLimited || isViewsLimited;
    }

    @JsonIgnore
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }


    public long getViews() {
        return views;
    }

    public void setViews(long remainingViews) {
        this.views = remainingViews;
    }

    @JsonProperty("time")
    public long getRemainingTimeSecs() {

        return isTimeLimited ? SECONDS.between(LocalTime.now(), creationDate.toLocalTime()
                .plusSeconds(this.time)) : 0;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long seconds) {
        this.time = seconds;
    }

    @JsonIgnore
    public boolean isLimited() {
        return isLimited;
    }

    public void setLimited(boolean limited) {
        isLimited = limited;
    }

    @JsonIgnore
    public boolean isTimeLimited() {
        return isTimeLimited;
    }

    public void setTimeLimited(boolean timeLimited) {
        isTimeLimited = timeLimited;
    }
    @JsonIgnore
    public boolean isViewsLimited() {
        return isViewsLimited;
    }

    public void setViewsLimited(boolean viewsLimited) {
        isViewsLimited = viewsLimited;
    }

    public void decrementViews() {
        this.views--;
    }

    @JsonIgnore
    public boolean isStillValid() {
    if(isViewsLimited) return views > 0;
    if(isTimeLimited) return getRemainingTimeSecs() > 0;
    return true;
    }
}
