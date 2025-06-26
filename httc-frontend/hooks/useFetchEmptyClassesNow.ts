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
  const body = {};
  const response = await axios.post(`${API_URL}`, body);
  return response?.data;
};
