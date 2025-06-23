import { View, StyleSheet } from "react-native";
import { ThemedText } from "./ThemedText";

export const ClassCard = ({ title, description }) => {
  return (
    <View style={styles.card}>
      <ThemedText style={styles.title}>{title}</ThemedText>
      <ThemedText style={styles.description}>{description}</ThemedText>
    </View>
  );
};

const styles = StyleSheet.create({
  card: {
    backgroundColor: "#ffffff",
    borderRadius: 12,
    padding: 16,
    margin: 12,
    shadowColor: "#000",
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.1,
    shadowRadius: 4,
    elevation: 3,
  },
  title: {
    fontSize: 18,
    fontWeight: "600",
    marginBottom: 8,
    color: "#1c1c1e",
  },
  description: {
    fontSize: 14,
    color: "#1c1c1e",
  },
});
