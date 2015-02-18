package io.pivotal.bling.server.api.msg;

/**
 * @author sgupta
 * @since 2/9/15.
 */
public class GenericResponse {
  private final Status status;
  private final ErrorCode code;
  private final String message;

  /**
   * convenience constructor for 'ok' status and null code and message
   */
  public GenericResponse() {
    status = Status.ok;
    code = null;
    message = null;
  }

  public GenericResponse(Status status, ErrorCode code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;
  }

  public Status getStatus() {
    return status;
  }

  public ErrorCode getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
