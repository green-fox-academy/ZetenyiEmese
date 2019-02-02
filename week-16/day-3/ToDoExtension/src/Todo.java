import java.io.Serializable;
import java.time.*;
import java.util.Optional;

public class Todo implements Serializable {

  private int id;
  private String description;
  private LocalDateTime createdAt;
  private LocalDateTime completedAt;

  public Todo(int id, String description) {
    this.id = id;
    this.description = description;
    this.createdAt = LocalDateTime.now(Clock.systemUTC());
  }

  public Todo(int id, String description, LocalDateTime createdAt) {
    this.id = id;
    this.description = description;
    this.createdAt = createdAt;
  }

  public Todo(int id, String description, LocalDateTime createdAt, LocalDateTime completedAt) {
    this.id = id;
    this.description = description;
    this.createdAt = createdAt;
    this.completedAt = completedAt;
  }

  public int getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getCompletedAt() {
    return completedAt;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void complete() {
    completedAt = LocalDateTime.now(Clock.systemUTC());
  }

  public boolean isCompleted() {
    return completedAt != null && completedAt.isBefore(LocalDateTime.now(Clock.systemUTC()));
  }

  public Optional<Duration> completionTime() {
    if (isCompleted()) {
      return Optional.of(Duration.between(createdAt, completedAt));
    } else {
      return Optional.empty();
    }
  }

//  public Duration completionTime() {
//    if (isCompleted()) {
//      return Duration.between(createdAt, completedAt);
//    }
//    return null;
//  }

  private String completionTimeToString() {
    if (completionTime().isPresent()) {
      int seconds = (int) completionTime().get().getSeconds();
      int days = seconds / (24 * 3600);
      seconds = seconds % (24 * 3600);
      int hours = seconds / 3600;
      seconds = seconds % 3600;
      int minutes = seconds / 60;
      return String.format(", completed in %d days, %d hours, %d minutes", days, hours, minutes);

    } else {
      return "";
    }
  }

  @Override
  public String toString() {
    return (isCompleted() ? "[x] " : "[ ] ") + description + " [id: " + id + "]" + completionTimeToString();
  }

}
