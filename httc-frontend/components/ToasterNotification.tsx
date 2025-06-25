import { useEffect } from "react";
import { useToast } from "react-native-toast-notifications";

export const ToasterNotification = ({ message, severity }) => {
  const toast = useToast();

  useEffect(() => {
    toast.show(message, {
      type: severity,
      duration: severity === "danger" ? 0 : 5000,
    });
  }, []);
  return <></>;
};
