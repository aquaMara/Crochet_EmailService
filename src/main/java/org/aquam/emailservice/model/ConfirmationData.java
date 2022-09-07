package org.aquam.emailservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;

@Value
public class ConfirmationData {

    private final String email;
    private final String confirmationLink;
}
