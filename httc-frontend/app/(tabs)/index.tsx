import { Image } from "expo-image";
import { Platform, StyleSheet } from "react-native";
import { View, ActivityIndicator } from "react-native";
import { HelloWave } from "@/components/HelloWave";
import ParallaxScrollView from "@/components/ParallaxScrollView";
import { ThemedText } from "@/components/ThemedText";
import { ThemedView } from "@/components/ThemedView";
import { useFetchEmptyClassesNow } from "@/hooks/useFetchEmptyClassesNow";
import { ClassCard } from "@/components/ClassCard";
import { ToasterNotification } from "@/components/ToasterNotification";
import { ClassRoom } from "@/constants/Interface";

interface data {}

export default function HomeScreen() {
  const { data, isLoading, isError } = useFetchEmptyClassesNow();

  if (isLoading) {
    return (
      <View style={{ flex: 1, justifyContent: "center", alignItems: "center" }}>
        <ActivityIndicator size="large" color="#007bff" />
        <ThemedText>Loading the application...</ThemedText>
      </View>
    );
  }

  return (
    <ParallaxScrollView
      headerBackgroundColor={{ light: "#A1CEDC", dark: "#1D3D47" }}
      headerImage={
        <Image
          source={require("@/assets/images/partial-react-logo.png")}
          style={styles.reactLogo}
        />
      }
    >
      {isError && (
        <ToasterNotification
          message={"Data is still loading. Please try again soon."}
          severity={"danger"}
        />
      )}
      <ThemedView style={styles.titleContainer}>
        <ThemedText type="title">Available Classes</ThemedText>
        <HelloWave />
      </ThemedView>
      <ThemedView style={styles.stepContainer}>
        <ThemedText type="subtitle">List</ThemedText>
        {data?.map((room: ClassRoom) => (
          <ClassCard
            key={room.roomId}
            title={room.roomId}
            description={room.classAvailable}
          />
        ))}
      </ThemedView>
    </ParallaxScrollView>
  );
}

const styles = StyleSheet.create({
  titleContainer: {
    flexDirection: "row",
    alignItems: "center",
    gap: 8,
  },
  stepContainer: {
    gap: 8,
    marginBottom: 8,
  },
  reactLogo: {
    height: 178,
    width: 290,
    bottom: 0,
    left: 0,
    position: "absolute",
  },
});
