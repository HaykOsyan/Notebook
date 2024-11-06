package notebook_atestat.services.views;

public interface MessageView {
    void showSuccessMessage(String message);

    void showErrorMessage(String message);

    void showInfoMessage(String message);
}
