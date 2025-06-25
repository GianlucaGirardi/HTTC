import axios from "axios";
import { useQuery } from "@tanstack/react-query";
import { ClassRoom } from "@/constants/Interface";
import Constants from "expo-constants";

const API_URL = Constants.expoConfig?.extra?.API_URL;

export const useFetchEmptyClassesNow = () =>
  useQuery<ClassRoom[]>({
    queryKey: ["classRoom"],
    queryFn: getData,
  });

const getData = async () => {
  const response = await axios.get(API_URL);
  return response?.data;
};
