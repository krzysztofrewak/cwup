import sys


class VersionAction:
    def invoke(self):
        return f"python: {sys.version}"
