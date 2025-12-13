import requests
import pandas as pd

USERNAME = "VikramarjunVijaya"

# Load Striver's problems
df = pd.read_csv("strivers.csv")
df["Slug"] = df["Link"].str.split("/").str[-2]  # extract "two-sum", etc.

# LeetCode API query
query = """
{
  matchedUser(username: "%s") {
    problemsSolvedBeatsStats {
      question {
        titleSlug
      }
    }
  }
}
""" % USERNAME

url = "https://leetcode.com/graphql"
resp = requests.post(url, json={"query": query})
data = resp.json()

# Solved slugs
solved_slugs = {
    p["question"]["titleSlug"]
    for p in data["data"]["problemsSolvedBeatsStats"]
}

# Mark solved
df["Solved"] = df["Slug"].apply(lambda x: "✅" if x in solved_slugs else "❌")

print(f"Solved { (df['Solved'] == '✅').sum() } / {len(df)} problems")
df.to_csv("strivers.csv", index=False)