package miu.edu.cs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    private String email;
    private Label label;

    @Override
    public String toString() {
        return "Email{" +
                "email='" + email + '\'' +
                ", label=" + label +
                '}';
    }
}
